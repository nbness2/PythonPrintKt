import java.io.PrintStream

fun pyprint(
    vararg things: Any?,
    sep: String = " ",
    end: String = "\n",
    file: PrintStream = System.out,
    flush: Boolean = false
): Unit =
    StringBuilder().
        apply {
            things.forEachIndexed { index, thing ->
                append(thing)
                if (index != (things.size - 1)) {
                    append(sep)
                }
            }
            append(end)
        }.
        run {
            file.print(this)
            if (flush) {
                file.flush()
            }
        }
