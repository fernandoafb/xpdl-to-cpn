package dk.au.daimi.ascoveco.util;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author mw
 */
public class ParserUtil {

	/**
	 * @param n node
	 * @param childName childname
	 * @return whether the chil;dname is contained in node
	 */
	public static boolean containsChild(final Node n, final String childName) {
		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			if (ParserUtil.isElementNodeOfType(nl.item(i), childName)) { return true; }
		}

		return false;
	}

	/**
	 * Gives the value of a given attribute
	 * 
	 * @param n A <code>Node</code> which holds the attribute
	 * @param attrName The name of the attribute
	 * @return The value of the attribute or <code>null</code> if the attribute does not exsist
	 */
	public static String getAttr(final Node n, final String attrName) {
		String value = null;
		if (n.hasAttributes()) {
			final NamedNodeMap map = n.getAttributes();
			for (int i = 0; i < map.getLength(); i++) {
				final Node attrNode = map.item(i);
				if (attrNode.getNodeName().equals(attrName)) {
					value = attrNode.getNodeValue();
				}
			}
		}

		return value;
	}

	/**
	 * Gives the text form the child node with the name childName
	 * 
	 * @param n The <code>Node</code> which has the child
	 * @param childName The name of the child which has the desired text
	 * @return If the child exists the text that the child contained. If the child does not exist null is returned.
	 */
	public static String getTextFromChild(final Node n, final String childName) {
		final NodeList nl = n.getChildNodes();
		String nodeText = null;
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, childName)) {
				nodeText = ParserUtil.getTextFromElement(currentNode);
			}
		}

		return nodeText;
	}

	/**
	 * @param n node
	 * @return CDATA
	 */
	public static String getTextFromElement(final Node n) {
		final NodeList nl = n.getChildNodes();
		String nodeText = null;
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isTextNode(currentNode)) {
				if (nodeText == null) {
					nodeText = currentNode.getNodeValue();
				} else {
					nodeText += currentNode.getNodeValue();
				}
			}
		}

		if (nodeText != null) {
			return nodeText.trim();
		} else {
			return nodeText;
		}
	}

	/**
	 * @param n node
	 * @param type type
	 * @return whether node is of type
	 */
	public static boolean isElementNodeOfType(final Node n, final String type) {
		return n.getNodeType() == Node.ELEMENT_NODE && n.getNodeName().equals(type);
	}

	/**
	 * @param n node
	 * @return whether node is text node
	 */
	public static boolean isTextNode(final Node n) {
		return n.getNodeType() == Node.TEXT_NODE && n.getNodeName().equals("#text");
	}
}
