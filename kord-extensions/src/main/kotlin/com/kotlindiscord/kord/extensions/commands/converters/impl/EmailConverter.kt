package com.kotlindiscord.kord.extensions.commands.converters.impl

import com.kotlindiscord.kord.extensions.CommandException
import com.kotlindiscord.kord.extensions.commands.CommandContext
import com.kotlindiscord.kord.extensions.commands.converters.SingleConverter
import com.kotlindiscord.kord.extensions.commands.converters.email
import com.kotlindiscord.kord.extensions.commands.converters.emailList
import com.kotlindiscord.kord.extensions.commands.parser.Argument
import dev.kord.common.annotation.KordPreview
import dev.kord.rest.builder.interaction.OptionsBuilder
import dev.kord.rest.builder.interaction.StringChoiceBuilder
import org.apache.commons.validator.routines.EmailValidator

/**
 * Argument converter for email address arguments.
 *
 * @see email
 * @see emailList
 */
@OptIn(KordPreview::class)
public class EmailConverter(
    override var validator: (suspend Argument<*>.(String) -> Unit)? = null
) : SingleConverter<String>() {
    override val signatureTypeString: String = "converters.email.signatureType"

    override suspend fun parse(arg: String, context: CommandContext): Boolean {
        if (!EmailValidator.getInstance().isValid(arg)) {
            throw CommandException(
                context.translate("converters.email.error.invalid", replacements = arrayOf(arg))
            )
        }

        this.parsed = arg

        return true
    }

    override suspend fun toSlashOption(arg: Argument<*>): OptionsBuilder =
        StringChoiceBuilder(arg.displayName, arg.description).apply { required = true }
}
