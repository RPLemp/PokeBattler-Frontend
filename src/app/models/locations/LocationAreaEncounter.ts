import NamedAPIResource from '../common/NamedAPIResource';
import VersionDetail from '../games/VersionDetail';

interface LocationAreaEncounter {
	location_area: NamedAPIResource,
	version_details: VersionDetail[]
}

export default LocationAreaEncounter;
