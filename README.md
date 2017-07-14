# How To: Java Gmail

This "How To Guide" provides a the boilerplate needed to send e-mail via gmail in Java. This uses Java Mail, a feature of Java EE. The logic to send the mail is wrapped in a servlet for simple testing.


# Prerequisite

This guide presumes knowledge on install and use of the following:
* Gradle
* Liberty
* WebSphere Developer Tools (WDT)


# Build and Deploy

* Step 1 - Build the WAR
  * Run `gradle` to build the WAR in `build/libs/howto-java-gmail.war`
* Step 2 - Create the server
  * Copy `howto-java-gmail` to your Liberty servers directory
  * `cp -r howto-java-gmail/ wlp_user_dir/servers/howto-java-gmail/`
* Step 3 - Start the server
  * `bin/server run howto-java-gmail`
* Step 4 - Deploy the WAR
  * Move the built WAR into `dropins`
  * `mv build/libs/howto-java-gmail.war wlp_user_dir/servers/howto-java-gmail/dropins`


# Import into Eclipse

The following are high-level instructions for importing this project into Eclipse

1. Run `gradle eclipse` to generate the .project and other files needed by Eclipse
2. Import -> Projects from Git


# Acknowledgements

This boilerplate was lifted / inspiried by two very useful resources:
[mkyong.com](https://www.mkyong.com)'s guide [JavaMail API – Sending email via Gmail SMTP example](https://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/) and [wasdev](https://developer.ibm.com/wasdev)'s guide [How to write an application using JavaMail](https://developer.ibm.com/wasdev/docs/write-application-using-javamail/)

