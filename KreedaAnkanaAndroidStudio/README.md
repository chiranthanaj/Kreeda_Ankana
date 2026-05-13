# Kreeda Ankana (Android Studio)

This project converts the HTML prototype and the PDF scope into a native Android app with:
- Firebase Authentication
- Firestore real-time bookings and challenges
- Room DB for local score history
- Kotlin + Jetpack Compose + MVVM
- Bottom navigation for Ground, Challenge, Scores, and My Team

## Firebase setup
1. Open your Firebase project:
   - Project name: **Kreeda Ankana**
   - Project ID: **kreeda-ankana-9e14d**
   - Project number: **1033834849571**
2. Download `google-services.json` from Firebase Console.
3. Put it here: `app/google-services.json`
4. Enable:
   - Authentication → Email/Password
   - Firestore Database
5. Create Firestore in test mode for development, then lock rules later.

## Android Studio setup
1. Open the folder in Android Studio.
2. Let Gradle sync.
3. Add your Firebase config file.
4. Run on a device/emulator.

## Firestore structure used
- `teams/{uid}`
- `bookings/{ground_date_slot}`
- `challenges/{challengeId}`
- `challenges/{challengeId}/replies/{replyId}`
- `scores/{scoreId}`

## Notes
- This is a working starter project and can be extended with notifications, image upload, and analytics later.
