package id.my.hendisantika.specmaticsample.service

import id.my.hendisantika.specmaticsample.model.DB
import org.springframework.stereotype.Service

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-specmatic-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/07/25
 * Time: 05.58
 * To change this template use File | Settings | File Templates.
 */
@Service
class MetricService {
    fun activeUsers(): Int {
        return DB.userCount()
    }
}