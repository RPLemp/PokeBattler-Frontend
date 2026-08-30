import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

import Pokemon from '../models/pokemon/Pokemon';

@Injectable({
  providedIn: 'root'
})
export class PokeFetchService {
  private readonly client: HttpClient = inject(HttpClient);
  private readonly pokemonSubject = new BehaviorSubject<Pokemon | null>(null);
  public pokemon$: Observable<Pokemon | null> = this.pokemonSubject.asObservable();

  getPokemon(index: number): void {
    this.client.get<any>(`https://pokeapi.co/api/v2/pokemon/${index}`)
      .subscribe(json => {
        this.pokemonSubject.next({
          name: json.name,
          id: json.id,
        });
      });
  }
}
