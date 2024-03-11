# Android MVVM backed by Jetpack UI and Navigation, Retrofit2, Hilt, Flows, and Coroutines



## Description

The project is about sending a get request to the server and parsing the response as JSON format to show in the application with details.

## Table of Contents

- Features
- Architecture
- Getting Started
- Usage
- Contributing
- License

## Features

- Nodes: this feature includes sending the request to the server and showing responses with moving and deleting.
- Details: while the user clicks on items in the LazyList of Nodes page, it will redirect to the details feature(page) to gather details of relevant nodes from the server.

## Architecture

This project follows the **Clean Architecture** principles. It separates concerns into layers:

1. **Presentation Layer**:
   - Android UI components (Compose based Screens)
   - Dependency on the Domain layer
   - Responsible for user interactions

2. **Domain Layer**:
   - Business logic and use cases
   - Independent of other layers
   - Defines interfaces for data access

3. **Data Layer**:
   - Implements data sources (remote) (in this app I did not use offline mechanisms like Room.
   - Communicates with external services (APIs)
   - Depends on the Domain layer


## Getting Started

1. Clone this repository.
2. Open the project in Android Studio.
3. Build and run the app on an emulator or device.

## Usage

Provide instructions on how to use your app. Include screenshots or GIFs if possible.

## Contributing

Contributions are welcome! If you'd like to contribute, follow these steps:
1. Fork the repository.
2. Create a new branch.
3. Make your changes.
4. Submit a pull request.

## License

This project is licensed under the Apache License.
