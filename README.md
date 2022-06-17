# Project 3 - *Parstagram*

**Parstagram** is a photo sharing app using Parse as its backend.

Time spent: **25** hours spent in total

## User Stories

The following **required** functionality is completed:

- [Y] User sees app icon in home screen.
- [Y] User can sign up to create a new account using Parse authentication
- [Y] User can log in to their account
- [Y] The current signed in user is persisted across app restarts
- [Y] User can log out of their account
- [Y] User can take a photo, add a caption, and post it to "Instagram"
- [Y] User can view the last 20 posts submitted to "Instagram"
- [Y] User can pull to refresh the last 20 posts submitted to "Instagram"
- [Y] User can tap a post to go to a Post Details activity, which includes timestamp and caption.

The following **stretch** features are implemented:

- [Y] Style the login page to look like the real Instagram login page.
- [Y] Style the feed to look like the real Instagram feed.
- [ ] User can load more posts once they reach the bottom of the feed using endless scrolling.
- [Y] User should switch between different tabs using fragments and a Bottom Navigation View.
  - [Y] Feed Tab (to view all posts from all users)
  - [Y] Capture Tab (to make a new post using the Camera and Photo Gallery)
  - [Y]Profile Tab (to view only the current user's posts, in a grid)
- [Y] Show the username and creation time for each post
- User Profiles:
  - [ ] Allow the logged in user to add a profile photo
  - [Y] Display the profile photo with each post
  - [ ] Tapping on a post's username or profile photo goes to that user's profile page
  - [Y] User Profile shows posts in a grid
- [ ] After the user submits a new post, show an indeterminate progress bar while the post is being uploaded to Parse
- [ ] User can comment on a post and see all comments for each post in the post details screen.
- [ ] User can like a post and see number of likes for each post in the post details screen.

The following **additional** features are implemented:

- [ ] List anything else that you can get done to improve the app functionality!
- [Y] implemented a splash screen

Please list two areas of the assignment you'd like to **discuss further with your peers** during the next class (examples include better ways to implement something, how to extend your app in certain ways, etc):

1. How to better utilize inheritance for classes that operate very similarly
2. Updating JSONArray values

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://github.com/likitag/Parstagram/blob/811d846bfa4831e985fe00fbd3af77e74325eed6/insta_walkthrough.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [Kap](https://getkap.co/).

## Credits

List an 3rd party libraries, icons, graphics, or other assets you used in your app.

- [Android Async Http Client](http://loopj.com/android-async-http/) - networking library


## Notes

I found that navigating between fragments was quite tricky, compared to navigating between activities. I also spent a bit of time trying to implement
the capturing a profile image feature and the adding likes stretch features, but was not able to fully implement them for this submission. 

## License

    Copyright [2022] [Likita]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
