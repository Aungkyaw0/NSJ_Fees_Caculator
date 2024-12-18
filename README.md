# North Sussex Judo's Fees Calculator 🥋

A Java console application that calculates training fees for judo athletes based on their training plan, private coaching hours, and competition participation.

## 📋 Features

- User registration and login system
- Three training plan options:
  - Beginner (2 sessions/week)
  - Intermediate (3 sessions/week) 
  - Elite (5 sessions/week)
- Private coaching hour calculations
- Competition fee calculations
- Weight category classification
- Detailed fee breakdown
- User-friendly console interface

## 🏗️ System Requirements

- Java Development Kit (JDK) 17 or higher
- Any Java IDE (IntelliJ IDEA recommended)

## ⚙️ Installation Guide

1. Clone the repository:
2. Open the project in your IDE:
   - For IntelliJ IDEA:
     - Go to `File > Open`
     - Navigate to the cloned repository
     - Select the project folder
     - Click `OK`

3. Build the project:
   - IntelliJ IDEA will automatically build the project
   - Ensure all dependencies are resolved

## 🚀 Usage Guide

1. Run the program:
   - Locate `Main.java` in the project explorer
   - Right-click and select `Run 'Main.main()'`

2. Using the Application:

   a. **Login/Register**
   - Choose option 1 to register as a new user
   - Choose option 2 to login with existing username
   - Choose option 3 to exit the program

   b. **Training Plan Selection**
   - Choose from available plans:
     - Beginner (£25.00/week)
     - Intermediate (£30.00/week)
     - Elite (£35.00/week)

   c. **Additional Services**
   - Enter current weight for category classification
   - Opt for private coaching hours (£9.50/hour)
   - Enter competition participation (£22.00/competition)

   d. **View Results**
   - See detailed fee breakdown
   - View weight category classification
   - Check total monthly costs

## 💰 Pricing Structure

| Service | Cost |
|---------|------|
| Beginner Training | £25.00/week |
| Intermediate Training | £30.00/week |
| Elite Training | £35.00/week |
| Private Coaching | £9.50/hour |
| Competition Entry | £22.00/competition |

## 🏋️ Weight Categories

| Category | Weight Range |
|----------|--------------|
| Fly Weight | ≤ 66.00 kg |
| Light Weight | 66.01 - 73.00 kg |
| Light-Middle Weight | 73.01 - 81.00 kg |
| Middle Weight | 81.01 - 90.00 kg |
| Light-Heavy Weight | 90.01 - 100.00 kg |
| Heavy Weight | > 100.00 kg |

## 🛠️ Technical Details

- Written in Java
- Object-Oriented Design
- Interface-based implementation
- Input validation
- Console-based UI
- Modular architecture

## 📝 Notes

- Maximum 20 private coaching hours allowed
- Monthly fees are calculated based on 4 weeks
- Competition fees only apply to Intermediate and Elite plans
- New users are automatically registered as beginners
- System maintains a list of registered users

## Development
- Original Developer: Aung Kyaw Thu (Aungkyaw0)
- Initial Release: 7/05/2022
- Version: 1.0

## 🤝 Contributing

Feel free to fork this repository and submit pull requests for any improvements.

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.
