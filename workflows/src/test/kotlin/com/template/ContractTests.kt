package com.template

import com.template.contracts.TemplateContract
import com.template.flows.Initiator
import net.corda.testing.node.MockServices
import org.junit.Test

class ContractTests {
    private val ledgerServices = MockServices(listOf(
            TemplateContract::class.java.`package`.name,
            Initiator::class.java.`package`.name))

    @Test
    fun `dummy test`() {

    }
}