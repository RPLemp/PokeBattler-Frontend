import NamedAPIResource from '../common/NamedAPIResource';
import Name from '../common/Name';
import APIResource from '../common/APIResource';

export interface MoveStatAffect {
  change: number;
  move: NamedAPIResource;
}

export interface MoveStatAffectSets {
  increase: MoveStatAffect[];
  decrease: MoveStatAffect[];
}

export interface NatureStatAffectSets {
  increase: NamedAPIResource[];
  decrease: NamedAPIResource[];
}

interface StatJSON {
  id: number;
  name: string;
  game_index: number;
  is_battle_only: boolean;
  affecting_moves: MoveStatAffectSets;
  affecting_natures: NatureStatAffectSets;
  characteristics: APIResource[];
  move_damage_class: NamedAPIResource | null;
  names: Name[];
}

export default StatJSON;
