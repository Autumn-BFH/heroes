import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatDialogModule } from '@angular/material/dialog';
import { CampComponent } from './camp/camp.component';
import { MatListModule } from '@angular/material/list';
import { SelectHeroesDialogComponent } from './select-heroes-dialog/select-heroes-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    CampComponent,
    SelectHeroesDialogComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatCardModule,
    MatDialogModule,
    MatListModule
  ],
  entryComponents: [
    SelectHeroesDialogComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
