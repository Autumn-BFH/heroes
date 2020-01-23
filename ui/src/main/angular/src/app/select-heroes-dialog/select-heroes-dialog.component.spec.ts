import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectHeroesDialogComponent } from './select-heroes-dialog.component';

describe('SelectHeroesDialogComponent', () => {
  let component: SelectHeroesDialogComponent;
  let fixture: ComponentFixture<SelectHeroesDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelectHeroesDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectHeroesDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
