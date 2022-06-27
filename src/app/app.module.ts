import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core'
import { NativeScriptModule } from '@nativescript/angular'

import { AppRoutingModule } from './app-routing.module'
import { AppComponent } from './app.component'
import { MenuComponent } from './menu/menu.component'
import { GameComponent } from './game/game.component'
import { CounterComponent } from './game/counter/counter.component'
import { ResultsComponent } from './game/results/results.component'
import { ItemComponent } from './game/item-container/item.component'

@NgModule({
  bootstrap: [AppComponent],
  imports: [NativeScriptModule, AppRoutingModule],
  declarations: [AppComponent, MenuComponent, GameComponent, CounterComponent, ResultsComponent, ItemComponent],
  providers: [],
  schemas: [NO_ERRORS_SCHEMA],
})
export class AppModule {}
