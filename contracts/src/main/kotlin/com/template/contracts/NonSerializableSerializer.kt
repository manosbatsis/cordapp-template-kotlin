package com.template.contracts

import com.template.contracts.NonSerializableSerializer.Proxy
import net.corda.core.serialization.SerializationCustomSerializer
import net.corda.core.utilities.loggerFor

class NonSerializableSerializer : SerializationCustomSerializer<NonSerializable, Proxy> {

    companion object{
        val logger = loggerFor<NonSerializableSerializer>()
    }
    /**
     * This is the actual proxy class that is used as an intermediate representation
     * of the Example class
     */
    data class Proxy(val property: String)

    /**
     * This method should be able to take an instance of the type being proxied and
     * transpose it into that form, instantiating an instance of the Proxy object (it
     * is this class instance that will be serialized into the byte stream.
     */
    override fun toProxy(obj: NonSerializable): Proxy {
        logger.debug("NonSerializableSerializer toProxy")
        return Proxy(property = obj.property)
    }

    /**
     * This method is used during deserialization. The bytes will have been read
     * from the serialized blob and an instance of the Proxy class returned, we must
     * now be able to transform that back into an instance of our original class.
     *
     * In our example this requires us to evoke the static "of" method on the
     * Example class, transforming the serialized properties of the Proxy instance
     * into a form expected by the construction method of Example.
     */
    override fun fromProxy(proxy: Proxy) : NonSerializable {
        logger.debug("NonSerializableSerializer fromProxy")
        return NonSerializable(proxy.property)
    }
}
