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
import model.refs.NiveauDanger;

@SuppressWarnings("serial")
@MappedSuperclass
/**
 * Une classe annotée @MappedSuperClass est aussi une classe "persistante",
 *  mais ce ne n'est pas une entitÃ©, et à ce titre, on ne peut donc pas faire de requete dessus.
 *   Ses champs sont enregistrées en base,
 *  et sont associées aux champs de toutes les entitées des sous-classes de cette classe.
 * @author codeur
 *
 */
@FieldDefaults(level=AccessLevel.PRIVATE)
public abstract class AssociationEntityEnum implements Serializable {

	// Champs techniques
	@Id
	@Convert(converter=UUIDConverter.class)
	UUID idTable1;	
	
	// Champs techniques
	@Id
	NiveauDanger enumeration;
	
	// Champs techniques
	@Id
	@Convert(converter=LocalDateConverter.class)
	LocalDate dateDebut;
	
		
	public UUID getIdtable1() {
		return idTable1;
	}
	
	public NiveauDanger getEnumeration() {
		return enumeration;
	}
	
	public AssociationEntityEnum() {
		this.idTable1=UUID.randomUUID();
		dateDebut = LocalDate.now();
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTable1 == null) ? 0 : idTable1.hashCode()) + ((enumeration == null) ? 0 : enumeration.hashCode())+ ((dateDebut == null) ? 0 : dateDebut.hashCode());
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
		AssociationEntityEnum other = (AssociationEntityEnum) obj;
		if (idTable1 == null) {
			if (other.idTable1 != null)
				return false;
		} else if (!idTable1.equals(other.idTable1))
			return false;
		
		if (enumeration == null) {
			if (other.enumeration != null)
				return false;
		} else if (!enumeration.equals(other.enumeration))
			return false;
		
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		return true;
	}

	
	
}