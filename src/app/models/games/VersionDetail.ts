import NamedAPIResource from '../common/NamedAPIResource';
import EncounterDetail from '../locations/EncounterDetail';

interface VersionDetail {
	version: NamedAPIResource,
	max_chance: number,
	encounter_details: EncounterDetail[],
}

export default VersionDetail;
