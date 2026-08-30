import NamedAPIResource from '../common/NamedAPIResource';

interface VersionGroupJSON {
  id: number;
  name: string;
  order: number;
  generation: NamedAPIResource;
  move_learn_methods: NamedAPIResource[];
  pokedexes: NamedAPIResource[];
  regions: NamedAPIResource[];
  versions: NamedAPIResource[];
}

export default VersionGroupJSON;
