import NamedAPIResource from '../common/NamedAPIResource';
import Name from '../common/Name';

interface GenerationJSON {
  id: number;
  name: string;
  abilities: NamedAPIResource[];
  names: Name[];
  main_region: NamedAPIResource;
  moves: NamedAPIResource[];
  pokemon_species: NamedAPIResource[];
  types: NamedAPIResource[];
  version_groups: NamedAPIResource[];
}

export default GenerationJSON;
