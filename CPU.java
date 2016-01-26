/*
 *
 * Name: CPU.java
 * Author: Richard Hsu
 * Overview: This will be the CPU class of the Processor. 
 * It is made up of different functions to handle the different
 * instructions that need to be carried out. (EX: Load/Store...)
 *
*/


import java.util.BitSet;

public class CPU
{
	public static void main(String [] args)
	{
		// declare the different registers that we need

		// 4 general purpose registers (GPRs)
		short[] GPR = new short[4];

		// 3 index registers
		short[] IR = new short[3];

		// 1 instruction register
		short[] ISR = new short[1];

		// PC (12 bits - implemented as a bitset)
		BitSet PC = new BitSet(12);

		System.out.println(PC);
		System.out.println("Length: " + PC.length());

		// test example 
		// suppose: instruction is stored at address 4
		PC.set(2);

		System.out.println("Address of Memory: " + PC.toString());


		// memory - Now implemented as an array of 2048 (can change later)
		short[] memory = new short[2048];

		// storing an insturction into index 4
		memory[4] = 1104;


		// retrieve the value
		int index = bitSetToInt(PC);
		System.out.println(index);
		
		
		//System.out.println(PC.toString());

		process_instruction(index, ISR, memory);




	}

	
	public static void process_instruction(int index, short[] ISR, short[] memory)
	{
		// fetch the value that PC is pointing to (an instruction) and move it into IR
		ISR[0] = memory[index];

		System.out.println("Instruction stored at ISR. ISR = " + memory[index]);

		int [] parameters = new int[5];

		// parse the instruction at ISR into Opcode, R, IX, I, Address
		parameters = parseInstruction(ISR[0]);

		// check the parameters array and see that everything is there
		for (int i = 0; i < parameters.length; i++)
		{
			System.out.println(parameters[i]);
		}
	}


	// converts the address PC is pointing to into an int
	public static int bitSetToInt(BitSet bitSet)
	{
	    int bitInteger = 0;
	    for(int i = 0 ; i < 32; i++)
	        if(bitSet.get(i))
	            bitInteger |= (1 << i);
	    return bitInteger;
	}

	// parse the value stored at that index to turn instruction into a sequence of bits
	public static int [] parseInstruction(short instruction)
	{
		// convert the short to int and then to a binary strng
		String instructionStringRaw = Integer.toBinaryString(0xFFFF & instruction);

		// make sure that we have 16 bits in the string
		String instructionString = Integer.toBinaryString(0x10000 | instruction).substring(1);

		System.out.println(instructionString);


		String optcode = instructionString.substring(0, 6);
		System.out.println("Opcode: " + optcode);
		int optcodeValue = Integer.parseInt(optcode, 2);
		System.out.println("Opcode: " + optcodeValue);

		String GPR = instructionString.substring(6, 8);
		System.out.println("GPR: " + GPR);
		int GPRValue = Integer.parseInt(GPR, 2);
		System.out.println("GPR: " + GPRValue);

		String IR = instructionString.substring(8, 10);
		System.out.println("Index Register: " + IR);
		int IRValue = Integer.parseInt(IR, 2);
		System.out.println("Index Register: " + IRValue);

		String IA = instructionString.substring(10, 11);
		System.out.println("IA: " + IA);
		int IAValue = Integer.parseInt(IA, 2);
		System.out.println("IA: " + IAValue);

		String address = instructionString.substring(11, 16);
		System.out.println("Address: " + address);
		int addressValue = Integer.parseInt(address, 2);
		System.out.println("Address: " + addressValue);

		int [] parameters = {optcodeValue, GPRValue, IRValue, IAValue, addressValue};
		return parameters;
	}

}