package org.acme.actors.test;

import java.util.List;

import org.dawb.passerelle.common.actors.AbstractDataMessageTransformer;
import org.dawb.passerelle.common.message.DataMessageComponent;
import org.dawb.passerelle.common.message.MessageUtils;

import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

import com.isencia.passerelle.actor.ProcessingException;

public class TestActor extends AbstractDataMessageTransformer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8808664164352113469L;

	public TestActor(CompositeEntity container, String name) throws NameDuplicationException, IllegalActionException {
		super(container, name);
	}

	@Override
	protected String getOperationName() {
		return "Hello World Actor";
	}

	@Override
	protected DataMessageComponent getTransformedMessage(List<DataMessageComponent> cache) throws ProcessingException {
		
        final DataMessageComponent ret = MessageUtils.mergeAll(cache);
        ret.putScalar("message_text", "Hello World");
		return ret;
	}

}
