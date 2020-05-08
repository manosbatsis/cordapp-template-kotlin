package com.template.states

import net.corda.core.serialization.CordaSerializable

// without @CordaSerializable we get a java.io.NotSerializableException
// in com.template.contracts.ContractTests
// as the custom SerializationCustomSerializer is ignored
// @CordaSerializable
data class NonSerializable(
        val property: String
)