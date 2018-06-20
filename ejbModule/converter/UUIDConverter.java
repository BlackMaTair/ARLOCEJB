package converter;



import java.util.UUID;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converter JPA 
 * UUID <=>String(varchar)
 * @author warti
 *
 */
@Converter(autoApply = true)
public class UUIDConverter implements AttributeConverter<UUID, String>{

	@Override
	public String convertToDatabaseColumn(UUID arg0) {
		// TODO Auto-generated method stub
		return arg0.toString();
	}

	@Override
	public UUID convertToEntityAttribute(String arg0) {
		// TODO Auto-generated method stub
		return UUID.fromString(arg0);
	}

}

