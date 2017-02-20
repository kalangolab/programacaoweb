package br.com.kalango.lab.services.handlers;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class UsuarioHandlerMessage implements SOAPHandler<SOAPMessageContext> {

	@Override
	public void close(MessageContext arg0) {

	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return false;
	}

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Boolean request = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (!request) {
			try {
				SOAPMessage msg = context.getMessage();
				SOAPEnvelope env = msg.getSOAPPart().getEnvelope();
				SOAPHeader header = env.getHeader();
				if (header == null) {
					header = env.addHeader();
					return false;
				}
				Node node = (Node) header.getElementsByTagName("token").item(0);
				String token = node.getChildNodes().item(0).getNodeValue();
				if (token != null && token.equals("Kalango Lab")) {
					System.out.println("Token válido");
					return true;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		return true;
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}

}
