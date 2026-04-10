🔹 STEP 1: Clone the repo
git clone https://github.com/amrutha0307/Lost-and-Found.git
cd Lost-and-Found

🔹 STEP 2: Open project in IntelliJ
Open the folder
Wait for dependencies to load
Run once (make sure it works)

🔹 STEP 3: Create your own branch

👉 Based on your use case:

git checkout -b feature/found-item     # Anusha
git checkout -b feature/match          # Anurag
git checkout -b feature/claim          # Archi

Then push:

git push -u origin <branch-name>


🔹 STEP 4: Follow THIS STRUCTURE (MANDATORY)

Inside:

com.lostfound

Create/use:

controller
service
service.impl
repository
model
dto

🔹 STEP 5: RULES (VERY IMPORTANT)

❗ DO NOT:

Push to main
Modify others’ files
Change folder structure

✅ DO:

Work only in your module
Follow MVC:
Controller → Service → Repository → Model
Commit regularly
🔹 STEP 6: Module ownership
Person	Module
You	Lost Item
Anusha	Found Item
Anurag	Match & Notify
Archi	Claim & Verification
🔹 STEP 7: Database

👉 Use SAME DB config:

spring.datasource.url=jdbc:mysql://localhost:3306/lost_found_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

🔹 STEP 8: Integration later

👉 Don’t depend on others now
👉 Use dummy data if needed
👉 We will integrate later
