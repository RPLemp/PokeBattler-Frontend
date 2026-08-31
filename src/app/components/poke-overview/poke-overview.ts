import {Component, inject, OnInit} from '@angular/core';
import {map, Observable, of, switchMap, tap} from 'rxjs';
import { AsyncPipe } from '@angular/common';

import Pokemon from '../../models/pokemon/Pokemon';
import {PokeMockService} from '../../services/PokeMockService';
import {PokePictureService} from '../../services/PokePictureService';

@Component({
  imports: [
    AsyncPipe
  ],
  selector: 'app-poke-overview',
  styleUrl: './poke-overview.css',
  templateUrl: './poke-overview.html',
})
export class PokeOverview implements OnInit {
	protected pokeService = inject(PokeMockService);
	private readonly pictureService = inject(PokePictureService);

  protected pokemon: Observable<Pokemon | null> = this.pokeService.pokemon$.pipe(
		switchMap((pokemon) => {
			if (!pokemon)
				return of(null);

			return this.pictureService.getPictureFrontDefault(pokemon.id).pipe(
				map((blob: Blob) => {
						return {
							...pokemon,
							frontDefault: blob,
							frontDefaultUrl: URL.createObjectURL(blob)
					};
				})
			)
		})
	);

  ngOnInit(): void {
    this.getPokemon();
  }

  getPokemon(): void {
    this.pokeService.getPokemon();
  }
}
