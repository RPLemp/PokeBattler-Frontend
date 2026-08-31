import NamedAPIResource from '../common/NamedAPIResource';
import LocationAreaEncounter from '../locations/LocationAreaEncounter';

export interface PokemonAbility {
  is_hidden: boolean;
  slot: number;
  ability: NamedAPIResource;
}

export interface PokemonType {
  slot: number;
  type: NamedAPIResource;
}

export interface PokemonStat {
  base_stat: number;
  effort: number;
  stat: NamedAPIResource;
}

export interface PokemonMoveVersion {
  move_learn_method: NamedAPIResource;
  version_group: NamedAPIResource;
  level_learned_at: number;
}

export interface PokemonMove {
  move: NamedAPIResource;
  version_group_details: PokemonMoveVersion[];
}

export interface PokemonSprites {
  front_default: string | null;
  front_shiny: string | null;
  front_female: string | null;
  front_shiny_female: string | null;
  back_default: string | null;
  back_shiny: string | null;
  back_female: string | null;
  back_shiny_female: string | null;
  other?: Record<string, any>;
  versions?: Record<string, any>;
}

export interface PokemonHeldItemVersion {
  rarity: number;
  version: NamedAPIResource;
}

export interface PokemonHeldItem {
  item: NamedAPIResource;
  version_details: PokemonHeldItemVersion[];
}

export interface PokemonTypePast {
  generation: NamedAPIResource;
  types: PokemonType[];
}

export interface PokemonCries {
  latest: string;
  legacy: string;
}

export interface VersionGameIndex {
  game_index: number;
  version: NamedAPIResource;
}

interface PokemonJSON {
  id: number;
  name: string;
  base_experience?: number;
  height?: number;
  is_default?: boolean;
  order?: number;
  weight?: number;
  abilities?: PokemonAbility[];
  forms?: NamedAPIResource[];
  game_indices?: VersionGameIndex[];
  held_items?: PokemonHeldItem[];
  location_area_encounters?: LocationAreaEncounter[];
  moves?: PokemonMove[];
  past_types?: PokemonTypePast[];
  sprites?: PokemonSprites;
  cries?: PokemonCries;
  species?: NamedAPIResource;
  stats?: PokemonStat[];
  types?: PokemonType[];
}

export default PokemonJSON;
