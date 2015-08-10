package org.nem.core.model.mosaic;

import org.nem.core.crypto.PublicKey;
import org.nem.core.model.*;
import org.nem.core.model.namespace.*;
import org.nem.core.model.primitive.BlockHeight;

import java.util.Properties;

/**
 * Common place to have Mosaic-related constants accessible from all modules.
 */
public class MosaicConstants {
	// TODO 20150807 J-*: should all the fees just go to the NEM DEV POST V1 fund?
	// TODO 20150808 BR -> J: We could use it for node rewards too. I would say we simply collect it to a separate account and decide later.
	// TODO 20150810 J-*: if we do that, we'll need to make these accounts multisig
	private static final PublicKey NAMESPACE_OWNER_NEM_KEY = PublicKey.fromHexString("3e82e1c1e4a75adaa3cba8c101c3cd31d9817a2eb966eb3b511fb2ed45b8e262");
	private static final PublicKey MOSAIC_CREATION_FEE_SINK_KEY = PublicKey.fromHexString("53e140b5947f104cabc2d6fe8baedbc30ef9a0609c717d9613de593ec2a266d3");

	/**
	 * The maximum allowable quantity of a mosaic.
	 */
	public static final long MAX_QUANTITY = 9_000_000_000_000_000L;

	/**
	 * The 'nem' namespace owner.
	 */
	public static final Account NAMESPACE_OWNER_NEM = new Account(Address.fromPublicKey(NAMESPACE_OWNER_NEM_KEY));

	/**
	 * The 'nem' namespace id.
	 */
	public static final NamespaceId NAMESPACE_ID_NEM = new NamespaceId("nem");

	/**
	 * The 'nem' namespace.
	 */
	public static final Namespace NAMESPACE_NEM = new Namespace(NAMESPACE_ID_NEM, NAMESPACE_OWNER_NEM, BlockHeight.MAX);

	/**
	 * The mosaic creation fee sink.
	 */
	public static final Account MOSAIC_CREATION_FEE_SINK = new Account(Address.fromPublicKey(MOSAIC_CREATION_FEE_SINK_KEY));

	/**
	 * The xem mosaic id.
	 */
	public static final MosaicId MOSAIC_ID_XEM = new MosaicId(NAMESPACE_ID_NEM, "xem");

	/**
	 * The 'nem.xem' mosaic definition.
	 */
	public static final MosaicDefinition MOSAIC_DEFINITION_XEM = createXemMosaicDefinition();

	private static MosaicDefinition createXemMosaicDefinition() {
		final MosaicDescriptor descriptor = new MosaicDescriptor("reserved xem mosaic");
		final Properties properties = new Properties();
		properties.put("divisibility", "6");
		properties.put("initialSupply", "8999999999");
		properties.put("mutableSupply", "false");
		properties.put("transferable", "true");
		return new MosaicDefinition(
				NAMESPACE_OWNER_NEM,
				MOSAIC_ID_XEM,
				descriptor,
				new DefaultMosaicProperties(properties),
				null);
	}
}
