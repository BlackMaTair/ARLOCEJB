package model.refs.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Convert;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import converter.LocalDateConverter;
import converter.UUIDConverter;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@SuppressWarnings("serial")
@MappedSuperclass
/**
 * Une classe annotée @MappedSuperClass est aussi une classe "persistante",
 *  mais ce ne n'est pas une entité, et à ce titre, on ne peut donc pas faire de requêtes dessus.
 *   Ses champs sont enregistrés en base,
 *  et sont associés aux champs de toutes les entités des sous-classes de cette classe.
 * @author codeur
 *
 */
@FieldDefaults(level=AccessLevel.PRIVATE)
public abstract class AssociationEntityUUID implements Serializable {

	// Champs techniques
	@Id
	@Convert(converter=UUIDConverter.class)
	UUID idTable1;	
	
	// Champs techniques
	@Id
	@Convert(converter=UUIDConverter.class)
	UUID idTable2;
	
	// Champs techniques
	@Id
	@Convert(converter=LocalDateConverter.class)
	LocalDate dateDebut;
	
		
	public UUID getIdTable1() {
		return idTable1;
	}
	
	public UUID getIdTable2() {
		return idTable2;
	}
	
	public AssociationEntityUUID() {
		this.idTable1=UUID.randomUUID();
		this.idTable2=UUID.randomUUID();
		dateDebut = LocalDate.now();
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTable1 == null) ? 0 : idTable1.hashCode()) + ((idTable2 == null) ? 0 : idTable2.hashCode())+ ((dateDebut == null) ? 0 : dateDebut.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssociationEntityUUID other = (AssociationEntityUUID) obj;
		if (idTable1 == null) {
			if (other.idTable1 != null)
				return false;
		} else if (!idTable1.equals(other.idTable1))
			return false;
		
		if (idTable2 == null) {
			if (other.idTable2 != null)
				return false;
		} else if (!idTable2.equals(other.idTable2))
			return false;
		
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		return true;
	}

	
	
}