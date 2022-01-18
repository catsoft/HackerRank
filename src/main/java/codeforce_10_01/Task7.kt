package codeforce_10_01

import ITask
import java.io.InputStream
import java.io.PrintStream
import java.util.*
import kotlin.collections.HashSet

class Task7 : ITask {
    override fun solve(input: InputStream, output: PrintStream) {
        val keyboard = Scanner(input)
        val count = keyboard.nextInt()
        keyboard.nextLine()
        for (i in 0 until count) {
            keyboard.nextLine()
            val (n, m) = keyboard.nextLine().split(" ").filter { it.isNotBlank() }.map { it.toInt() }.toIntArray()

            val fullTree = Array(n + 1) { mutableListOf<Edge>() }

            for (j in 0 until m) {
                val (a, b, c) = keyboard.nextLine().split(" ").filter { it.isNotBlank() }.map { it.toInt() }
                    .toIntArray()
                fullTree[a].add(Edge(b, c))
                fullTree[b].add(Edge(a, c))
            }

            for (k in fullTree.indices) {
                fullTree[k] = fullTree[k].groupBy { it.verticle }
                    .map { Edge(it.key, it.value.map { it.weight }.reduce { acc, edge -> acc or edge }) }
                    .toMutableList()
            }

            var answer = Int.MAX_VALUE
            for (j in 1 until fullTree.size) {
                val l = Math.min(answer, goDown(fullTree, j, hashSetOf(j), 0))
                answer = l
            }

            output.println(answer)
        }
    }

    fun goDown(
        fullTree: Array<MutableList<Edge>>,
        currentVerticle: Int,
        currentGraph: HashSet<Int>,
        currentDown: Int
    ): Int {
        val childrens = fullTree[currentVerticle].filter { !currentGraph.contains(it.verticle) }
        if (childrens.isEmpty()) {
            if (currentGraph.size != fullTree.size - 1) {
                return Int.MAX_VALUE
            }
            return currentDown
        }

        return childrens.map { child ->
            val copy = currentGraph.toHashSet()
            copy.add(child.verticle)
            goDown(fullTree, child.verticle, copy, child.weight or currentDown)
        }.minOrNull()!!
    }

    class Edge(val verticle: Int, val weight: Int)
}