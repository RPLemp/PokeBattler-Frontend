import NamedAPIResource from '../common/NamedAPIResource';
import VerboseEffect from '../common/VerboseEffect';
import Name from '../common/Name';

export interface MoveMetaData {
  ailment: NamedAPIResource;
  category: NamedAPIResource;
  min_hits: number | null;
  max_hits: number | null;
  min_turns: number | null;
  max_turns: number | null;
  drain: number;
  healing: number;
  crit_rate: number;
  ailment_chance: number;
  flinch_chance: number;
  stat_chance: number;
}

export interface MoveStatChange {
  change: number;
  stat: NamedAPIResource;
}

export interface MoveFlavorText {
  flavor_text: string;
  language: NamedAPIResource;
  version_group: NamedAPIResource;
}

export interface MoveMachineVersionDetail {
  machine: { url: string };
  version_group: NamedAPIResource;
}

export interface PastMoveStatValues {
  accuracy: number | null;
  effect_chance: number | null;
  power: number | null;
  pp: number | null;
  effect_entries: VerboseEffect[];
  type: NamedAPIResource | null;
  version_group: NamedAPIResource;
}

interface MoveJSON {
  id: number;
  name: string;
  accuracy: number | null;
  effect_chance: number | null;
  pp: number;
  priority: number;
  power: number | null;
  contest_combos?: any;
  contest_type?: NamedAPIResource;
  contest_effect?: { url: string };
  damage_class: NamedAPIResource;
  effect_entries: VerboseEffect[];
  effect_changes: any[];
  learned_by_pokemon?: NamedAPIResource[];
  flavor_text_entries: MoveFlavorText[];
  generation: NamedAPIResource;
  machines?: MoveMachineVersionDetail[];
  meta?: MoveMetaData;
  names: Name[];
  past_values?: PastMoveStatValues[];
  stat_changes?: MoveStatChange[];
  super_contest_effect?: { url: string };
  target: NamedAPIResource;
  type: NamedAPIResource;
}

export default MoveJSON;
