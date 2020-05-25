package com.template.contracts

import net.corda.core.contracts.BelongsToContract
import net.corda.core.contracts.ContractState
import net.corda.core.identity.AbstractParty

// *********
// * State *
// *********
@BelongsToContract(TemplateContract::class)
data class TemplateState(val data: String, val nonSerializable: NonSerializable, override val participants: List<AbstractParty> = listOf()) : ContractState
