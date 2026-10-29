package id.my.hendisantika.specmaticsample.model

import tools.jackson.core.JsonParser
import tools.jackson.databind.DeserializationContext
import tools.jackson.databind.deser.jdk.StringDeserializer

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-specmatic-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/07/25
 * Time: 05.56
 * To change this template use File | Settings | File Templates.
 */
class StrictStringDeserializer : StringDeserializer() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): String? {
        val token = p.currentToken()
        if (token.isBoolean
            || token.isNumeric
            || !token.toString().equals("VALUE_STRING", ignoreCase = true)
        ) {
            ctxt.reportInputMismatch<Any>(String::class.java, "%s is not a `String` value!", token.toString())
            return null
        }
        return super.deserialize(p, ctxt)
    }
}