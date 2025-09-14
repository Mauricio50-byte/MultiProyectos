import pyautogui
import time

# Function to send multiple messages
def send_multiple_messages(base_message, count):
    for i in range(count):
        # Create the numbered message
        numbered_message = f"{i + 1}. {base_message}"
        
        # Type the message
        pyautogui.write(numbered_message)
        
        # Press Enter to send
        pyautogui.press('enter')
        
        print(f"Message {i + 1} sent.")
        
        # Wait 1 second between messages (adjust as needed)
        time.sleep(100)

# Base message to send
base_message = "Hello"  # Use an appropriate message here

# Number of times to send the message
message_count = 100

# Make sure to have the target application window open and selected
print("You have 5 seconds to focus on the chat window...")
time.sleep(0.1)  # Time to switch to the target window

# Execute the function
send_multiple_messages(base_message, message_count)