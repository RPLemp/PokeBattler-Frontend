import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AsyncPipe } from '@angular/common';

import { PokeFetchService } from '../../services/PokeFetchService';
import Pokemon from '../../models/pokemon/Pokemon';

@Component({
  imports: [
    AsyncPipe
  ],
  selector: 'app-poke-overview',
  styleUrl: './poke-overview.css',
  templateUrl: './poke-overview.html',
})
export class PokeOverview implements OnInit {
  protected pokemon: Observable<Pokemon | null>;

  constructor(protected service: PokeFetchService) {
    this.pokemon = this.service.pokemon$;
  }

  ngOnInit(): void {
    this.getPokemon(1);
  }

  getPokemon(id: number): void {
    this.service.getPokemon(id);
  }
}
