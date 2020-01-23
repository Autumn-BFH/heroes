import { Component, Inject, ViewChild } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatSelectionList } from '@angular/material/list';
import { Hero } from '../hero';

@Component({
  selector: 'app-select-heroes-dialog',
  templateUrl: './select-heroes-dialog.component.html',
  styleUrls: ['./select-heroes-dialog.component.css']
})
export class SelectHeroesDialogComponent {
  @ViewChild(MatSelectionList, {
    static: false
  }) heroesSelection: MatSelectionList;

  constructor(@Inject(MAT_DIALOG_DATA) public data, private ref: MatDialogRef<SelectHeroesDialogComponent>) {
  }

  save() {
    this.ref.close(this.heroesSelection.selectedOptions.selected.map(option => option.value));
  }

  isSelected(hero: Hero) {
    return this.data.party.members.filter(member => member.id === hero.id).length > 0;
  }

  isDisabled(hero: Hero) {
    return this.data.opponent.members.filter(member => member.id === hero.id).length > 0;
  }
}
