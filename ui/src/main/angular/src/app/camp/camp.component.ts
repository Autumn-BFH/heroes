import { Component, OnInit } from '@angular/core';

import { Hero } from '../hero';
import { HeroService } from '../hero.service';
import { MatDialog } from '@angular/material/dialog';
import { SelectHeroesDialogComponent } from '../select-heroes-dialog/select-heroes-dialog.component';
import { BehaviorSubject, Subject } from 'rxjs';
import { Challenge } from '../challenge';
import { PromoterService } from '../promoter.service';

@Component({
  selector: 'app-camp',
  templateUrl: './camp.component.html',
  styleUrls: ['./camp.component.css']
})
export class CampComponent implements OnInit {
  private parties$ = new BehaviorSubject<Challenge>({
    challengee: {
      name: 'Gegner',
      members: []
    },
    challenger: {
      name: 'Herausforderer',
      members: []
    }
  });
  heroes: Hero[];

  private fightResult$ = new Subject<string>();

  constructor(private heroService: HeroService, private promoterService: PromoterService, private dialog: MatDialog) {
  }

  ngOnInit() {
    this.getHeroes();
  }

  getHeroes(): void {
    this.heroService.getHeroes()
      .subscribe(heroes => this.heroes = heroes);
  }

  selectHeroes(partyType: string) {
    const dialogRef = this.dialog.open(SelectHeroesDialogComponent, {
      minWidth: '500px',
      data: {
        heroes: this.heroes,
        party: this.parties$.getValue()[partyType],
        opponent: partyType === 'challenger' ? this.parties$.getValue().challengee : this.parties$.getValue().challenger
      }
    });


    dialogRef.afterClosed()
      .subscribe(data => {
        if (!data) {
          return;
        }

        this.parties$.next({
          ...this.parties$.getValue(),
          [partyType]: {
            ...this.parties$.getValue()[partyType],
            members: data
          }
        });
      });
  }

  get fightButtonDisabled() {
    return this.parties$.getValue().challenger.members.length < 1 || this.parties$.getValue().challengee.members.length < 1;
  }

  fight() {
    const parties = this.parties$.getValue();
    this.fightResult$.next('');

    this.promoterService.promoteFight(parties)
      .subscribe(res => {
        this.fightResult$.next(res);
      });
  }
}
