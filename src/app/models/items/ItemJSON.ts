import NamedAPIResource from '../common/NamedAPIResource';
import VerboseEffect from '../common/VerboseEffect';
import Name from '../common/Name';
import GenerationGameIndex from '../common/GenerationGameIndex';

export interface ItemSprites {
  default: string | null;
}

export interface ItemHolderPokemonVersionDetail {
  rarity: number;
  version: NamedAPIResource;
}

export interface ItemHolderPokemon {
  pokemon: NamedAPIResource;
  version_details: ItemHolderPokemonVersionDetail[];
}

export interface ItemFlavorText {
  text: string;
  version_group: NamedAPIResource;
  language: NamedAPIResource;
}

interface ItemJSON {
  id: number;
  name: string;
  cost: number;
  fling_power: number | null;
  fling_effect: NamedAPIResource | null;
  attributes: NamedAPIResource[];
  category: NamedAPIResource;
  effect_entries: VerboseEffect[];
  flavor_text_entries: ItemFlavorText[];
  game_indices: GenerationGameIndex[];
  names: Name[];
  sprites: ItemSprites;
  held_by_pokemon: ItemHolderPokemon[];
  baby_trigger_for?: { url: string } | null;
  machines?: { machine: { url: string }; version_group: NamedAPIResource }[];
}

export default ItemJSON;
