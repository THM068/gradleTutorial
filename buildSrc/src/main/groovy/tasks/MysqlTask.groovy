package com.gradle.tasks
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by tm1c14 on 17/06/2015.
 */
class MysqlTask extends DefaultTask {

    def hostname = 'localhost'
    def port = 3306
    def sql
    def database
    def username = 'root'
    def password = 'zinzilee'

    @TaskAction
    def runQuery() {
        def cmd

        if(database) {
            cmd = "mysql -u ${username} -p${password} -h${hostname} -P ${port} ${database} -e "
        }
        else {
            cmd = "mysql -u ${username} -p${password} -h ${hostname} -P ${port} -e "
        }

        project.exec {
            commandLine = cmd.split().toList() + sql
        }
    }
}