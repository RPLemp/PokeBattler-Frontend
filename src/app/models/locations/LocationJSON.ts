import NamedAPIResource from '../common/NamedAPIResource';
import Name from '../common/Name';
import GenerationGameIndex from '../common/GenerationGameIndex';

interface LocationJSON {
  id: number;
  name: string;
  region: NamedAPIResource | null;
  names: Name[];
  game_indices: GenerationGameIndex[];
  areas: NamedAPIResource[];
}

export default LocationJSON;
