import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {PokeOverview} from './components/poke-overview/poke-overview';

@Component({
	imports: [RouterOutlet, PokeOverview],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('PokeBattler');
}
