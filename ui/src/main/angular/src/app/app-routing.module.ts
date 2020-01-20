import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CampComponent } from './camp/camp.component';
import { HeroComponent } from './hero/hero.component';


const routes: Routes = [
  { path: '', redirectTo: '/camp', pathMatch: 'full' },
  { path: 'camp', component: CampComponent },
  { path: 'hero/:id', component: HeroComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
