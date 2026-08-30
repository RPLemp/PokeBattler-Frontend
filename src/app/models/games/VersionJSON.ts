import NamedAPIResource from '../common/NamedAPIResource';
import Name from '../common/Name';

interface VersionJSON {
  id: number;
  name: string;
  names: Name[];
  version_group: NamedAPIResource;
}

export default VersionJSON;
