package com.Nicogeta.InvincibleFences;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;

public class InvincibleFencesBlockListener extends BlockListener {

	final InvincibleFences plugin;

	public InvincibleFencesBlockListener(InvincibleFences instance) {
		plugin = instance;
	}

	public void onBlockDamage(BlockDamageEvent event) {
		Player player = event.getPlayer();

		boolean canBreakFences = false;
		if((InvincibleFences.Permissions == null && player.isOp()))
			canBreakFences = true;
		else if(InvincibleFences.Permissions != null & InvincibleFences.Permissions.has(player, "InvincibleFences.canBreak"))
			canBreakFences = true;

		if(!canBreakFences) {
			if(event.getBlock().getType() == Material.FENCE) {
				event.setCancelled(true);
			}
		}

	}

	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();

		boolean canBreakFences = false;
		if((InvincibleFences.Permissions == null && player.isOp()))
			canBreakFences = true;
		else if(InvincibleFences.Permissions != null & InvincibleFences.Permissions.has(player, "canBreak"))
			canBreakFences = true;

		if(!canBreakFences) {
			if(event.getBlock().getType() == Material.FENCE) {
				event.setCancelled(true);
			}
		}
	}

	public void onBlockIgnite(BlockIgniteEvent event) {
		if(event.getBlock().getType() == Material.FENCE) {
			event.setCancelled(true);
		}
	}

	public void onBlockBurn(BlockBurnEvent event) {
		if(event.getBlock().getType() == Material.FENCE) {
			event.setCancelled(true);
		}
	}

	public void onBlockPhysics(BlockPhysicsEvent event) {
		if(event.getBlock().getType() == Material.FENCE) {
			event.setCancelled(true);
		}
	}

	public void onBlockDispense(BlockDispenseEvent event) {
		if(event.getBlock().getType() == Material.FENCE) {
			event.setCancelled(true);
		}
	}

}
