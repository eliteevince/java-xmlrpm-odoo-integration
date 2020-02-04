# java-xmlrpm-odoo-integration
Odoo is a full of business software/application including e-commerce/website, CRM, accounting, billing, warehouse - and project management, inventory and manufacturing etc.
Odoo offers a choice of more than thousand modules, Odoo is available in the cloud or on-site and is most suited for small to mid-sized companies. It is flexible, has dynamic community and it can be adapted to your business needs. Odoo is also best integration software, we can use with many languages like Java, PHP, Python etc. Odoo is PostgreSQL for database.

**Odoo integration with Java**<br><br>
**Reuqirents**<br>
Odoo installer<br>
Java 8<br>
Library for xmlrpc 3.1.3<br>
<br>
**Step 1: Download and install odoo installer**<br>
You can found Odoo installer from given link. <br>
https://www.odoo.com/documentation/9.0/setup/install.html#setup-install-packaged <br> or <br>
https://nightly.odoo.com/9.0/nightly/ <br>
After successfully download odoo installer, just install odoo in your local system using installer, odoo will access using port **8069** which by default port for odoo server, and odoo is use PostgreSQL for storing databases.
<br>
<br>
**Step 2: Configure Odoo in local system**<br>
After successfully install Odoo, it will open in any browser with **localhost:8086** URL.<br>
while first time it will ask for database creation, enter database name, user name, password.
<br><br>
**Step 3: Install apps**<br>
In top right side there is menu displayed, at forth position you may found *Apps*. You can find all apps inside this menu.<br><br>
**Step 4: Setup Java program**<br>
Find **odoo-config.properties** file inside resource folder. you may found following configurations please change it according your convenience 
<pre><code>
PROTOCOL = http<br>
HOST = localhost<br>
PORT = 8069<br>
DB = <br>
USERNAME = <br>
PASSWORD = <br>
</code></pre><br><br>
**Step 4: Run and check output java program**<br>
after run this program you may get below output<br>

<pre><code>
Login
--------------
Login Successed, With user id: 1

Fetch all databases<br>
--------------
eliteevince
</code></pre>
<br>
**Congratulations... You are sucessfully integrated java with odoo using xmlrpc**
