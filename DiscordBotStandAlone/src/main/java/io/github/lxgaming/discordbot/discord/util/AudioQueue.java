/*
 * Copyright 2017 Alex Thomson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.lxgaming.discordbot.discord.util;

import java.util.ArrayList;
import java.util.List;

import io.github.lxgaming.discordbot.DiscordBot;
import io.github.lxgaming.discordbot.entries.Audio;

public class AudioQueue {
	
	private List<Audio> queue;
	
	public AudioQueue() {
		queue = new ArrayList<Audio>();
	}
	
	public void playNext() {
		Audio audio = getNext();
		if (audio != null) {
			DiscordBot.getInstance().getDiscord().getAudioPlayer().playTrack(getNext().getAudioTrack());
			return;
		}
		
		DiscordBot.getInstance().getDiscord().getAudioPlayer().playTrack(null);
	}
	
	private Audio getNext() {
		if (getQueue() == null || getQueue().isEmpty()) {
			return null;
		}
		
		Audio audio = getQueue().get(0);
		getQueue().remove(0);
		return audio;
	}
	
	public List<Audio> getQueue() {
		return queue;
	}
}