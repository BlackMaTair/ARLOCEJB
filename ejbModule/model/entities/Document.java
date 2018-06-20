package model.entities;

import java.time.LocalDate;

import javax.enterprise.context.Dependent;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import model.refs.Messages;
import model.refs.entities.AbstractEntity;


@SuppressWarnings("serial")


//CDI
@Dependent

//JPA
@Entity
@Table(name="DOCUMENT")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Document extends AbstractEntity{
	
	@Pattern(regexp = "[A-Za-z]*")
	@NotNull(message= Messages.ERREUR_NOM_DOCUMENT)
	@Column(name="NOM")
	String nom;
	
	@Pattern(regexp = "[A-Za-z]*")
	@NotNull(message= Messages.ERREUR_DESCRIPTIF_DOCUMENT)
	@Column(name="DESCRIPTIF")
	String descriptif;
	
	@NotNull
	LocalDate dateDepot;
	
	@NotNull(message= Messages.ERREUR_EMPLACEMENT_DOCUMENT)
	String emplacement;
	
	@NotNull
	TypeDocument typeDocument;
}