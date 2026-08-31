import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

import Pokemon from '../models/pokemon/Pokemon';
import NamedAPIResource from '../models/common/NamedAPIResource';
import { PokemonAbility, VersionGameIndex } from '../models/pokemon/PokemonJSON';

@Injectable({
  providedIn: 'root'
})
export class PokeMockService {
  private readonly client: HttpClient = inject(HttpClient);
  private readonly pokemonSubject = new BehaviorSubject<Pokemon | null>(null);
  public pokemon$: Observable<Pokemon | null> = this.pokemonSubject.asObservable();

  getPokemon(): void {
		this.pokemonSubject.next(this.getMew());
  }

  private getMew(): Pokemon {
    return {
      id: 151,
      name: "Mew",
      base_experience: 270,
      height: 4,
      is_default: true,
      order: 248,
      weight: 40,
      abilities: [{
        is_hidden: false,
        slot: 0,
        ability: {
          name: "Synchronize",
          url: "https://pokeapi.co/api/v2/ability/28/",
        } as NamedAPIResource
      } as PokemonAbility ],
      forms: [{
        name:"Mew",
        url:"https://pokeapi.co/api/v2/pokemon-form/151/"
        } as NamedAPIResource
      ],
      game_indices: [{
        game_index: 21,
        version: {
          name: "red",
          url: "https://pokeapi.co/api/v2/version/1/"
        } as NamedAPIResource
      } as VersionGameIndex, {
        game_index: 21,
        version: {
          name: "blue",
          url: "https://pokeapi.co/api/v2/version/2/"
        } as NamedAPIResource
      } as VersionGameIndex ],
      held_items: undefined,
      location_area_encounters: undefined,
      moves: undefined,
      past_types: [],
      sprites: {
				back_shiny: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/151.png",
				back_female: null,
				front_shiny: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/151.png",
				back_default: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/151.png",
				front_female: null,
				front_default: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/151.png",
				back_shiny_female: null,
				front_shiny_female: null,
				other: undefined,
				versions: undefined,
			},
      cries: undefined,
      species: {
				name:"mew",
				url:"https://pokeapi.co/api/v2/pokemon-species/151/"
			} as NamedAPIResource,
      stats: undefined,
      types: undefined,
    };
  }
}
