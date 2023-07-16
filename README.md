# Title+

Title Plus is a Minecraft plugin that enhances the `/title` command functionality, providing additional features and flexibility for displaying titles to players.

## Features

- Send custom titles to players with various options.
- Set the title color.
- Specify the title text.
- Control the title duration.
- Target specific players or broadcast to all players.
- Stop active titles individually or all at once.
- Reload the plugin for configuration changes.

## Usage

### `/titleplus <title> <duration> <player(* for all)>`

Send a title to players with the specified parameters:

- `<title>`: The text of the title.
- `<duration>`: The duration of the title in seconds.
- `<player(* for all)>`: Specify the target player or use "*" to send the title to all players.

Example: `/titleplus &cWelcome! 5 Player123`

This command will send the title "Welcome!" in red color to the player with the name "Player123" for 5 seconds.

### `/stoptitle <title_id or * for all>`

Stop active titles based on the provided title ID or stop all titles at once:

- `<title_id>`: The ID of the title to stop. Use "*" to stop all active titles.

Example: `/stoptitle 12345`

This command will stop the title with the ID "12345" if it is active.

### `/titlereload`

Reload the plugin to apply any configuration changes or updates:

Example: `/titlereload`

This command will reload the Title Plus plugin.

## Permissions

- `titleplus.use` - Allows players to use the `/titleplus` command.
- `titleplus.stoptitle` - Allows players to use the `/stoptitle` command.
- `titleplus.reload` - Allows players to use the `/titlereload` command.

## Support

If you encounter any issues or have any questions about Title Plus, you can reach out for support on the official Minecraft plugin forum or through the plugin's designated support channels.

## Credits

Title Plus plugin was developed by ArashAmini and is released under the [plugin's license](https://example.com/license).

## Version Compatibility

Title Plus is compatible with Minecraft version 1.16 and above.

Please note that some features may not be available in older versions due to differences in Minecraft APIs.

## Plugin Development

If you're interested in contributing to the development of Title Plus or want to report any issues or suggestions, you can find the plugin's source code and issue tracker on the official Title Plus repository on GitHub.

## License

Title Plus is released under the [plugin's license](https://example.com/license). Please review the license terms before using this plugin.

---

We hope you enjoy using Title Plus to enhance your Minecraft server with custom titles! If you have any feedback or suggestions, feel free to let us know. Happy gaming!