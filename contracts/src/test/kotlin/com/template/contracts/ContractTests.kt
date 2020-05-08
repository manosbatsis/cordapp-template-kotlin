package com.template.contracts

import com.template.states.NonSerializable
import com.template.states.TemplateState
import net.corda.core.identity.CordaX500Name
import net.corda.testing.core.TestIdentity
import net.corda.testing.node.MockServices
import net.corda.testing.node.ledger
import org.junit.Test

class ContractTests {
    private val partyA = TestIdentity(CordaX500Name("Party A", "London", "GB"))
    private val ledgerServices = MockServices(listOf(TemplateContract::class.java.`package`.name), partyA)

    @Test
    fun `dummy test`() {
        val state = TemplateState(
                data = "foo",
                nonSerializable = NonSerializable("bar"),
                participants = listOf(partyA.party)
        )
        ledgerServices.ledger {
            transaction {
                output(TemplateContract.ID, state)
                command(listOf(partyA.publicKey), TemplateContract.Commands.Action())
                verifies()
            }
        }
    }
}