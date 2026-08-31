import NamedAPIResource from '../common/NamedAPIResource';

interface EncounterDetail {
	min_level: number,
	max_level: number,
	chance: number,
	method: NamedAPIResource,
	condition_values: NamedAPIResource[],
}

export default EncounterDetail;
