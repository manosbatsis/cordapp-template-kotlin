package com.template

import com.template.contracts.TemplateContract
import com.template.flows.Initiator
import net.corda.core.identity.CordaX500Name
import net.corda.core.utilities.getOrThrow
import net.corda.testing.driver.DriverParameters
import net.corda.testing.driver.driver
import net.corda.testing.node.User
import net.corda.testing.node.internal.findCordapp

/**
 * Allows you to run your nodes through an IDE (as opposed to using deployNodes). Do not use in a production
 * environment.
 */
fun main(args: Array<String>) {
    val rpcUsers = listOf(User("user1", "test", permissions = setOf("ALL")))

    driver(DriverParameters(
            startNodesInProcess = true,
            waitForAllNodesToFinish = true,
            cordappsForAllNodes = listOf(
                    findCordapp(TemplateContract::class.java.`package`.name),
                    findCordapp(Initiator::class.java.`package`.name)
            ))) {
        startNode(providedName = CordaX500Name("PartyA", "London", "GB"), rpcUsers = rpcUsers).getOrThrow()
        startNode(providedName = CordaX500Name("PartyB", "New York", "US"), rpcUsers = rpcUsers).getOrThrow()
    }
}
