package de.hybris.training.core.util;

import de.hybris.platform.ticket.enums.CsTicketPriority;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;


public class CsTicketPriorityValues
{
	public static Map<String, Object> getPriorityValues()
	{

		final Map<String, Object> map = new HashMap<String, Object>();
		final Field[] fields = CsTicketPriority.class.getDeclaredFields();

		for (final Field field : fields)
		{
			final int modifier = field.getModifiers();
			if (Modifier.isPublic(modifier) && Modifier.isStatic(modifier) && Modifier.isFinal(modifier))
			{
				try
				{
					map.put(field.getName(), field.get(field.getName()));
				}
				catch (final Exception e)
				{
					e.getMessage();
				}
			}
		}

		final Map<String, Object> currentMap = map;
		return map;
	}
}
